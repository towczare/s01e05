package io.github.javafaktura.s01e05.weather.location;

import com.opencsv.CSVReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LocationFileProvider implements LocationProvider {

    private final Logger logger = LoggerFactory.getLogger(LocationFileProvider.class);
    private final String path;

    public LocationFileProvider(String path) {
        this.path = path;
    }

    @Override
    public List<Location> load() {
        List<Location> records = new ArrayList<Location>();
        try (CSVReader csvReader = new CSVReader(new FileReader(path))) {
            String[] values = null;
            while ((values = csvReader.readNext()) != null) {
                records.add(new Location(values[0], values[1]));
            }
        } catch (FileNotFoundException e) {
            logger.error("Can't read such file {}, {}", path);
        } catch (IOException e) {
            logger.error("Problem during file {} reading, {}", path);
        }
        return records;
    }
}
