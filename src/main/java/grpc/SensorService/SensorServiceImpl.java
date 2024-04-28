package grpc.SensorService;

import io.grpc.stub.StreamObserver;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class SensorServiceImpl extends SensorServiceGrpc.SensorServiceImplBase {

    private static final List<SensorData> SENSOR_DATA = new CopyOnWriteArrayList<>();

    static {
        try (Reader reader = Files.newBufferedReader(Paths.get("C:\\Users\\15305\\Downloads\\distributed-system-CA\\files\\sensor.csv"));
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader())) {

            for (CSVRecord csvRecord : csvParser) {
                int farmId = Integer.parseInt(csvRecord.get("farmid"));
                int sensorId = Integer.parseInt(csvRecord.get("sensorid"));
                int districtId = Integer.parseInt(csvRecord.get("districtid"));
                double temperature = Double.parseDouble(csvRecord.get("temperature"));
                int humidity = Integer.parseInt(csvRecord.get("humidity"));
                int illumination = Integer.parseInt(csvRecord.get("illumination"));

                SENSOR_DATA.add(new SensorData(farmId, sensorId, districtId, temperature, humidity, illumination));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void streamSensorData(SensorRequest request, StreamObserver<SensorResponse> responseObserver) {
        Timer timer = new Timer();
        final int[] index = {0};
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (index[0] < SENSOR_DATA.size()) {
                    SensorData data = SENSOR_DATA.get(index[0]);
                    SensorResponse response = SensorResponse.newBuilder()
                            .setFarmid(data.getFarmId())
                            .setSensorid(data.getSensorId())
                            .setDistrictid(data.getDistrictId())
                            .setTempreture(data.getTemperature())
                            .setHumidity(data.getHumidity())
                            .setIllumination(data.getIllumination())
                            .build();
                    responseObserver.onNext(response);
                    index[0]++;
                } else {
                    responseObserver.onCompleted();
                    timer.cancel();
                }
            }
        }, 0, 5000);
    }

    @Override
    public void addSensor(AddSensorRequest request, StreamObserver<AddSensorResponse> responseObserver) {
        boolean success = false;
        String message = "";

        int sensorId = request.getSensorid();
        String sensorType = request.getSensortype();
        int districtId = request.getDistrictid();

        try (Writer writer = Files.newBufferedWriter(Paths.get("C:\\Users\\15305\\Downloads\\distributed-system-CA\\files\\addsensor.csv"), StandardOpenOption.APPEND)) {
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("sensorid", "districtid", "sensortype"));
            csvPrinter.printRecord(sensorId, districtId, sensorType);
            csvPrinter.flush();
            success = true;
            message = "Sensor added successfully";
        } catch (IOException e) {
            e.printStackTrace();
            message = "Failed to add sensor: " + e.getMessage();
        }

        AddSensorResponse response = AddSensorResponse.newBuilder()
                .setSuccess(success)
                .setMessage(message)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    private static class SensorData {
        private final int farmId;
        private final int sensorId;
        private final int districtId;
        private final double temperature;
        private final int humidity;
        private final int illumination;

        public SensorData(int farmId, int sensorId, int districtId, double temperature, int humidity, int illumination) {
            this.farmId = farmId;
            this.sensorId = sensorId;
            this.districtId = districtId;
            this.temperature = temperature;
            this.humidity = humidity;
            this.illumination = illumination;
        }

        public int getFarmId() {
            return farmId;
        }

        public int getSensorId() {
            return sensorId;
        }

        public int getDistrictId() {
            return districtId;
        }

        public double getTemperature() {
            return temperature;
        }

        public int getHumidity() {
            return humidity;
        }

        public int getIllumination() {
            return illumination;
        }
    }
}
