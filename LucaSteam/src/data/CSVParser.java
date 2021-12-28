package data;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import model.CSVObject;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class CSVParser {

	public void parse() {
		try {
			FileReader fl = new FileReader("./src/csv/vgsales.csv");
			CSVReader reader = new CSVReaderBuilder(fl).withSkipLines(1). //
					build();
			List<CSVObject> csv_objectList = reader.readAll().stream().map(data -> {
				CSVObject csvObject = new CSVObject();
				csvObject.setName(data[1]);
				csvObject.setPlatform(data[2]);
				csvObject.setYear(data[3]);
				csvObject.setGenre(data[4]);
				csvObject.setPublisher(data[5]);

				return csvObject;
			}).collect(Collectors.toList());

			for (CSVObject csvObject : csv_objectList) {
				System.out.println(csvObject.getName());

			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (CsvException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
