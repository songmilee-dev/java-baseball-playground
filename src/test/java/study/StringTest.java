package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String testData = "1,2";
        String[] splitData = testData.split(",");

        assertThat(splitData).contains("1", "2");

        String[] splitOne = "1".split(",");
        assertThat(splitOne).containsExactly("1");
    }

    @Test
    void subString() {
        String testData = "(1,2)";
        String subString = testData.substring(1, testData.length() - 1);

        assertThat(subString).isEqualTo("1,2");
    }

    @Test
    @DisplayName("Test Exception:StringIndexOutOfBoundsException")
    void charAt() {
        String testData = "abc";

        assertThatThrownBy(() -> {
            testData.charAt(testData.length());
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
          .hasMessageContaining("String index out of range: 3");
    }
}
