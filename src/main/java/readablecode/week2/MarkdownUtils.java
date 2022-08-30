package readablecode.week2;

import java.util.List;

public class MarkdownUtils {
	// TODO1 : use early return:Readable code 7.5, 7.7 and remove the 1 nest(you
	// might need to change if condition and if condition is complicated such as
	// if(!(...)) please refactor it after you read 7.2)
	// * you do not need to improve exception handling

	// TODO2 : add line break and comment for each block/paragraph after you read
	// Readable code 4.7

	// TODO3 : re-name the variables after you read Readable code 2.2 2.7, 3.8

	// TODO4 : re-name method as it is after you read Readable code 3.0, 3.9

	// TODO5 : remove the unnecessary variable after you read Readable code 9.1

	public static String createTables(List<String> headerRow, int emptyRowCount) throws IllegalArgumentException {

		//引数で例外が渡ってきた場合
		if (headerRow == null || headerRow.isEmpty()) {
			throw new IllegalArgumentException("headerCaptions must not null and must have one more elements");
		}
		if (emptyRowCount < 1) {
			throw new IllegalArgumentException("emptyRowCount must be greater than or equal to 1");
		}


		StringBuilder markdownTable = new StringBuilder();
		// 見出しの行を作成
		for (String e : headerRow) {
			markdownTable.append("|");
			markdownTable.append(e);
		}
		markdownTable.append("|");
		markdownTable.append(System.lineSeparator());

		// separatorを作成
		for (String e : headerRow) {
			markdownTable.append("|");
			for (int i = 0; i < e.length(); i++) {
				markdownTable.append("-");
			}
		}
		markdownTable.append("|");
		markdownTable.append(System.lineSeparator());

		// 空の行を作成
		for (int i = 0; i < emptyRowCount; i++) {
			for (String e : headerRow) {
				markdownTable.append("|");
				for (int j = 0; j < e.length(); j++) {
					markdownTable.append(" ");
				}
			}
			markdownTable.append("|");
			markdownTable.append(System.lineSeparator());
		}
		return markdownTable.toString();
	}
}
