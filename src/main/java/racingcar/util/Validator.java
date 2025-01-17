package racingcar.util;

import java.util.Arrays;
import racingcar.view.ErrorMessage;

public class Validator {
    private static final String DELIMITER = ",";
    private static final String NO_INPUT = "";
    private static final int MIN_GAME_TIME = 1;
    private static final int CAR_NAME_MAX_LENGTH = 5;

    private Validator() {
    }

    public static String[] validateCarNames(String carNamesString) {
        String[] carNames = carNamesString.split(DELIMITER);
        validateCarNameLengthByArray(carNames);
        validateCarNameNoInputByArray(carNames);
        return carNames;
    }

    public static void validateCarName(String carName) {
        if (carName.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PREFIX + ErrorMessage.CAR_NAME_LENGTH);
        }
        if (carName.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PREFIX + ErrorMessage.NO_INPUT);
        }
    }

    public static int validateGameTime(int inputNumber) {
        validateGameTimeRange(inputNumber);
        return inputNumber;
    }

    private static void validateGameTimeRange(int inputNumber) {
        if (inputNumber <= MIN_GAME_TIME) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PREFIX + ErrorMessage.NOT_POSITIVE_NUMBER);
        }
    }

    public static void validateCarNameNoInputByArray(String[] split) {
        long noInputCount = Arrays.stream(split).filter(s -> s.trim().equals(NO_INPUT)).count();
        if (noInputCount >= 1) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PREFIX + ErrorMessage.NO_INPUT);
        }
    }

    public static void validateCarNameLengthByArray(String[] split) {
        long count = Arrays.stream(split).filter(s -> s.length() >= CAR_NAME_MAX_LENGTH)
                .count();
        if (count >= 1) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PREFIX + ErrorMessage.CAR_NAME_LENGTH);
        }
    }

}
