package readablecode.week2;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.google.common.collect.ImmutableList;

class MarkDownUtilsTest {

	@Test
	@DisplayName("第一引数がnull")
	void testCreateTable_ColumnCaptionIsNull() {

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			MarkDownUtils.createTables(null, 1);
		});

	}

	@Test
	@DisplayName("第一引数が空のリスト")
	void testCreateTable_ColumnCaptionIsEmpty() {

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			MarkDownUtils.createTables(new ArrayList<String>(), 1);
		});

	}

	@Test
	@DisplayName("第二引数が0以下")
	void testCreateTable_EmptyRowCountIsZero() {

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			MarkDownUtils.createTables(new ArrayList<String>(), 0);
		});

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			MarkDownUtils.createTables(new ArrayList<String>(), -1);
		});

	}

	@Test
	@DisplayName("単数のカラムと値が空の行を1行を持つテーブル")
	void testCreateTable_SingleColumnWithSingleEmptyRow() throws IllegalArgumentException {

		List<String> columnCaptions = ImmutableList.of("COL1");
		int emptyRowCount = 1;
		String actualMarkDownText = MarkDownUtils.createTables(columnCaptions, emptyRowCount);

		String expectedHeader = "|COL1|" + System.lineSeparator();
		String expectedSeparator = "|----|" + System.lineSeparator();
		String expectedRecoreds = "|    |" + System.lineSeparator();
		String expectedMarkDownText = expectedHeader + expectedSeparator + expectedRecoreds;

		assertThat(actualMarkDownText, is(expectedMarkDownText));

	}

	@Test
	@DisplayName("複数のカラムと値が空の行を複数行持つテーブル")
	void testCreateTable_MultipleColumnWithMultipleEmptyRows() throws IllegalArgumentException {

		List<String> columnCaptions = ImmutableList.of("COL1", "COL2");
		int emptyRowCount = 2;
		String actualMarkDownText = MarkDownUtils.createTables(columnCaptions, emptyRowCount);

		String expectedHeader = "|COL1|COL2|" + System.lineSeparator();
		String expectedSeparator = "|----|----|" + System.lineSeparator();
		String expectedRecoreds = "|    |    |" + System.lineSeparator() + "|    |    |" + System.lineSeparator();

		assertThat(actualMarkDownText, is(expectedHeader + expectedSeparator + expectedRecoreds));

	}

}