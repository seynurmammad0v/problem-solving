public class RomanToInteger {
    public int romanToInt(String s) {
        char[] sArr = s.toCharArray();
        int result = 0;
        int i = 0;
        for (; i < sArr.length - 1; i += 1) {

            switch (sArr[i]) {
                case 'I' -> {
                    if (sArr[i + 1] == 'V') {
                        result += 4;
                        i++;

                    } else if (sArr[i + 1] == 'X') {
                        result += 9;
                        i++;
                    } else {
                        result += 1;
                    }
                }
                case 'V' -> {
                    result += 5;
                }
                case 'X' -> {
                    if (sArr[i + 1] == 'L') {
                        result += 40;
                        i++;
                    } else if (sArr[i + 1] == 'C') {
                        result += 90;
                        i++;
                    } else {
                        result += 10;
                    }
                }
                case 'L' -> {
                    result += 50;
                }
                case 'C' -> {
                    if (sArr[i + 1] == 'D') {
                        result += 400;
                        i++;
                    } else if (sArr[i + 1] == 'M') {
                        result += 900;
                        i++;
                    } else {
                        result += 100;
                    }
                }
                case 'D' -> {
                    result += 500;
                }
                case 'M' -> {
                    result += 1000;
                }
            }

        }
        if ((sArr.length % 2 != 0 && i < sArr.length) || (sArr.length % 2 == 0 && i < sArr.length)) {
            switch (sArr[sArr.length - 1]) {
                case 'I' -> {
                    result += 1;
                }
                case 'V' -> {
                    result += 5;
                }
                case 'X' -> {
                    result += 10;
                }
                case 'L' -> {
                    result += 50;
                }
                case 'C' -> {
                    result += 100;
                }
                case 'D' -> {
                    result += 500;
                }
                case 'M' -> {
                    result += 1000;
                }
            }

        }

        return result;
    }
}