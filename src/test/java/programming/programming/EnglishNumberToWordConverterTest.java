package programming.programming;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class EnglishNumberToWordConverterTest {
	@InjectMocks
	EnglishNumberToWordConverter mock;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test(expected = RuntimeException.class)
	public void testOutOfRange() throws Exception {
		mock.convert(1000000000);
	}

	@Test
	public void testMaxValidNumber() throws Exception {
		String actual = mock.convert(999999999);
		Assert.assertEquals(
				"nine hundred ninety nine million nine hundred ninety nine thousand nine hundred ninety nine", actual);
	}

	@Test
	public void testValidNumber() throws Exception {
		String actual = mock.convert(12345);
		Assert.assertEquals("twelve thousand three hundred forty five", actual);
	}

}
