public class Main {
    // Weight for weight
    public static void quickSort(int[] SD, int[] D, int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = SD[(leftMarker + rightMarker) / 2];
        do {
            // Двигаем левый маркер слева направо пока элемент меньше, чем pivot
            while (SD[leftMarker] < pivot) {
                leftMarker++;
            }
            // Двигаем правый маркер, пока элемент больше, чем pivot
            while (SD[rightMarker] > pivot) {
                rightMarker--;
            }
            // Проверим, не нужно обменять местами элементы, на которые указывают маркеры
            if (leftMarker <= rightMarker) {
                // Левый маркер будет меньше правого только если мы должны выполнить swap
                if (leftMarker < rightMarker) {
                    int tmp = SD[leftMarker];
                    SD[leftMarker] = SD[rightMarker];
                    SD[rightMarker] = tmp;

                    int tmp1 = D[leftMarker];
                    D[leftMarker] = D[rightMarker];
                    D[rightMarker] = tmp1;
                }
                // Сдвигаем маркеры, чтобы получить новые границы
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        // Выполняем рекурсивно для частей
        if (leftMarker < rightBorder) {
            quickSort(SD, D, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            quickSort(SD, D, leftBorder, rightMarker);
        }
    }
    public static String orderWeight(String strng) {
        String[] words = strng.split(" ");
        int[] D = new int[words.length];
        int[] SD = new int[words.length];
        String[] w = new String[words.length];
        for (int i = 0; i < words.length; i++)
        {
            words[i] = words[i].trim();
            String x = words[i];
            D[i] = Integer.parseInt(x);
            char[] x0 = x.toCharArray();
            int S = 0;
            for (int j = 0; j < x0.length; j++)
            {
                int r = x0[j] - '0';
                S = S + r;
            }
            SD[i] = S;
        }


        quickSort(SD, D, 0, SD.length - 1);
        for (int i = 0; i < SD.length - 1; i++)
        {
            if (Integer.toString(SD[i]) == Integer.toString(SD[i+1]))
            {
                int u = 2;
                while (Integer.toString(SD[i]) == Integer.toString(SD[i + u]))
                {
                    u++;
                }
                int [] uno = new int[D.length];
                for (int k = i; k < i + u; k++)
                {
                    String z = Integer.toString(SD[k]);
                    uno[k] = z.length();
                }
                quickSort(uno, D, i, i + u - 1);
            }
        }
        String str = " ";
        for (int i = 0; i < D.length; i++)
        {
            str = str + D[i] + " ";
        }
        str = str.substring(0, str.length() - 1);
        str = str.trim();
        return str;
    }
    public static void main(String[] args) {
        String s = orderWeight("176  23 76 67 105 99");
    }
    }
