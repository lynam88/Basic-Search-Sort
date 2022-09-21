public class Comparison {

    public void bubbleSortCompare(float[] arr) {
        //Thời điểm trước khi gọi thuật toán
        System.out.print("Start Time = ");
        final long startTime = System.nanoTime();

        //Copy mảng đầu vào sang mảng b
        float[] b = arr.clone();

        //Chạy với giải thuật Bubble Sort trên mảng b
        boolean swapped;
        for (int i = 0; i < b.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < b.length - 1 - i; j++)
                if (b[j] > b[j + 1]) {
                    swap(b, j, j + 1);//Hoán vị phần tử sau và trước nếu phần tử trước lớn hơn sau
                    swapped = true;
                }
            if (!swapped) {
                break;
            }
        }

        //Thời điểm sau khi gọi thuật toán
        System.out.print("End Time = ");
        final long endTime = System.nanoTime();

        //Tổng thời gian chạy thuật toán
        System.out.println("Total execution time (milli second): " + (float) (endTime - startTime) / 1000000);
        System.out.println();

    }

    public void selectionSortCompare(float[] arr) {
        //Thời điểm trước khi gọi thuật toán
        System.out.print("Start Time = ");
        final long startTime = System.nanoTime();

        //Copy mảng đầu vào sang mảng b
        float[] b = arr.clone();

        //Chạy với giải thuật Selection Sort trên mảng b

        for (int i = 0; i < b.length - 1; i++) {

            int min = i;//Giả định chỉ số có giá trị thấp nhất là i
            for (int j = i + 1; j < b.length; j++)
                if (b[j] < b[min]) min = j;// Gán chỉ số có giá trị thấp nhấp
            if (min != i) swap(b, min, i);//Hoán vị phần tử có giá trị thấp nhất và phần tử giả định ban đầu

        }

        //Thời điểm sau khi gọi thuật toán
        System.out.print("End Time = ");
        final long endTime = System.nanoTime();

        //Tổng thời gian chạy thuật toán
        System.out.println("Total execution time (milli second): " + (float) (endTime - startTime) / 1000000);
        System.out.println();

    }

    public void insertionSortCompare(float[] arr) {
        //Thời điểm trước khi gọi thuật toán
        System.out.print("Start Time = ");
        final long startTime = System.nanoTime();

        //Copy mảng đầu vào sang mảng b
        float[] b = arr.clone();

        //Chạy với giải thuật Insertion Sort trên mảng b
        for (int i = 1; i < b.length; i++) {
            int j = i - 1;
            float temp = b[i];//Biến tạm thời dùng để so sánh và gán giá trị
            while (j >= 0 && b[j] > temp) {
                b[j + 1] = b[j];
                j--;
            }
            b[j + 1] = temp;

        }

        //Thời điểm sau khi gọi thuật toán
        System.out.print("End Time = ");
        final long endTime = System.nanoTime();

        //Tổng thời gian chạy thuật toán
        System.out.println("Total execution time (milli second): " + (float) (endTime - startTime) / 1000000);
        System.out.println();
    }

    void swap(float[] arr, int i, int k) {
        float x;
        x = arr[i];
        arr[i] = arr[k];
        arr[k] = x;
    }
}
