package ar.com.educacionit.bootcamp.parsers;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ar.com.educacionit.bootcamp.Articulo;

public class XLSArticuloFileParser implements Iparser {

	@Override
	public Collection<Articulo> parse(InputStream is) {
		var registros = new ArrayList<Articulo>();

		try (XSSFWorkbook workbook = new XSSFWorkbook(is)) {

			XSSFSheet spreadsheet = workbook.getSheetAt(0);

			for (Row cells : spreadsheet) {

				XSSFRow row = (XSSFRow) cells;
				registros.add(parseLine(row));
			}
		} catch (Exception e) {
			System.err.println(e);
		}

		return registros;
	}

	private Articulo parseLine(XSSFRow row) {
		Long editorialId = Math.round(row.getCell(0).getNumericCellValue());
		Long isbn = Math.round(row.getCell(1).getNumericCellValue());
		int paginas = (int) Math.round(row.getCell(2).getNumericCellValue());
		String idioma = row.getCell(3).getStringCellValue();
		LocalDate fechaPublicacion = row.getCell(4).getDateCellValue().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		// validaciones
		return new Articulo(editorialId, isbn, paginas, idioma, fechaPublicacion);
	}
}