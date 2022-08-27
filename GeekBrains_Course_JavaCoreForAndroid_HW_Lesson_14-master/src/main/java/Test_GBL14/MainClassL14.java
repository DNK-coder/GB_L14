package Test_GBL14;


public class MainClassL14 {
    public int[] cutFor(int[] arr) throws RuntimeException {
        // модуль поиска (удовлетворения основного условия - найти в массиве 4)
        if (arr.length == 0) {
            throw new RuntimeException("Пустой массив!");
        } else {
            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[i] == 4) {
                    int[] resArr = new int[arr.length - i - 1];
                    for (int j = 0; j < arr.length - i - 1; j++) {
                        resArr[j] = arr[i + j + 1];
                    }
                    return resArr;
                }
            }
        }
        throw new RuntimeException("Массив не содержит 4!");
    }

    public boolean containsOneOrFour(int[] arr) throws RuntimeException {
        // модуль поиска (проверить наличие в массиве 4 и 1 и только их)
        if (arr.length == 0) throw new RuntimeException("Пустой массив!");
        int elemIsFound = 0;
        for (int j : arr) {
            if (j != 4 && j != 1) return false;
            if (elemIsFound == 0) elemIsFound = j;
        }
        for (int j : arr) {
            if (elemIsFound != j) return true;
        }
        return false;
    }
}
