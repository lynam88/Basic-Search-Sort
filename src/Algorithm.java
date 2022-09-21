import java.io.*;//Nạp Package chứa class xử lý ngoại lệ

/**
 * Lớp Algorithm sẽ chứa các code liên quan tới thuật toán, nhập, in, đọc/ghi dữ liệu từ/vào file
 */
public class Algorithm {

    public void menu() {
        System.out.println();
        System.out.println("+-------------------Menu------------------+");
        System.out.println("|      1.Input                            |");
        System.out.println("|      2.Output                           |");
        System.out.println("|      3.Bubble sort                      |");
        System.out.println("|      4.Selection sort                   |");
        System.out.println("|      5.Insertion sort                   |");
        System.out.println("|      6.Search > value                   |");
        System.out.println("|      7.Search = value                   |");
        System.out.println("|      8.Algorithm Comparison             |");
        System.out.println("|      0.Exit                             |");
        System.out.println("+-----------------------------------------.+");
        System.out.println();
    }

    /**
     * Writing the array read from input array arr to file
     *
     * @param fileName The file name of file to write value
     * @param arr      The input float array
     */

    public void writeFile(String fileName, float arr[]) throws IOException {

        //Mở file
        FileWriter writer = new FileWriter(fileName);
        BufferedWriter buffer = new BufferedWriter(writer);

        //Ghi file
        for (int i = 0; i < arr.length; i++) {
            buffer.write((arr[i] + " "));
        }
        buffer.close();//Đóng file

    }

    /**
     * Reading the file then input to the array arr
     *
     * @param fileName The file name of file to read
     * @return Returning a array read from the file
     */

    public float[] readFile(String fileName) throws IOException {
        String url = "INPUT.txt";

        // Đọc dữ liệu theo từng dòng với BufferedReader
        FileInputStream fileInputStream = new FileInputStream(fileName);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        String line = bufferedReader.readLine();
        float[] a = new float[0];//Mảng lưu các phần tử tách từ xâu
        if (line != null) {
            String[] text = line.split(" ");//Tách xâu trong file INPUT.txt
            a = new float[text.length];
            for (int i = 0; i < a.length; i++) {
                a[i] = Float.parseFloat(text[i]);//Chuyển xâu thành float cho từng phần tử
            }
            bufferedReader.close();//Đóng file
        }
        return a;//Trả về mảng đọc từ file
    }

    /**
     * Hàm hiển thị mảng
     *
     * @param arr mảng cần hiển thị
     */
    void display(float[] arr) {
        int i;
        for (i = 0; i < arr.length; i++)
            System.out.print("  " + arr[i]);
        System.out.println();
    }

    /**
     * Hàm hoán vị
     *
     * @param arr mảng chứa phần tử cần hoán vị
     * @param i   chỉ số mảng cần hoán vị
     * @param k   chỉ số mảng cần hoán vị
     */
    void swap(float[] arr, int i, int k) {
        float x;
        x = arr[i];
        arr[i] = arr[k];
        arr[k] = x;
    }

    /**
     * Sorting the input array arr using Bubble Sort algorithm.
     *
     * @param arr Input array using for sorting
     * @return Returning a sorted array by using the Bubble Sort algorithm
     */

    public float[] bubbleSort(float arr[]) {
        //lưu giá trị vào mảng b
        float[] b = new float[arr.length];
        for (int i = 0; i < arr.length; i++) b[i] = arr[i];

        //sắp xếp trên mảng b
        for (int i = 0; i < b.length - 1; i++) {
            for (int j = 0; j < b.length - 1 - i; j++)
                if (b[j] > b[j + 1]) swap(b, j, j + 1);//Hoán vị phần tử sau và trước nếu phần tử trước lớn hơn sau

            //Hiển thị kết quả sắp xếp
            display(b);

        }
        return b;//Trả về mảng đã sắp xếp
    }

    /**
     * Sorting the input array arr using Selection Sort algorithm.
     *
     * @param arr Input array using for sorting
     * @return Returning a sorted array by using the Selection Sort algorithm
     */

    public float[] selectionSort(float arr[]) {
        //lưu giá trị vào mảng b
        float[] b = new float[arr.length];
        for (int i = 0; i < arr.length; i++) b[i] = arr[i];

        //sắp xếp trên mảng b
        for (int i = 0; i < b.length - 1; i++) {
            int min = i;//Giả định chỉ số có giá trị thấp nhất là i
            for (int j = i + 1; j < b.length; j++)
                if (b[j] < b[min]) min = j;// Gán chỉ số có giá trị thấp nhấp

            if(min != i) {
                swap(b, min, i);//Hoán vị phần tử có giá trị thấp nhất và phần tử giả định ban đầu
                //Hiển thị kết quả sắp xếp
                display(b);
            }

        }
        return b;//Trả về mảng đã sắp xếp

    }

    /**
     * Sorting the input array arr using Insertion Sort algorithm.
     *
     * @param arr Input array using for searching
     * @return Returning a sorted array by using the Insertion Sort algorithm
     */

    public float[] insertionSort(float arr[]) {
        //lưu giá trị vào mảng b
        float[] b = new float[arr.length];
        for (int i = 0; i < arr.length; i++) b[i] = arr[i];

        //sắp xếp trên mảng b
        for (int i = 1; i < b.length; i++) {
            int j = i - 1;
            float temp = b[i];//Biến tạm thời dùng để so sánh và gán giá trị
            while (j >= 0 && b[j] > temp) {
                b[j + 1] = b[j];
                j--;
            }
            b[j + 1] = temp;

            //Hiển thị kết quả sắp xếp
            display(b);

        }

        return b;//Trả về mảng đã sắp xếp
    }

    /**
     * Searching the indices of elements in array [arr] greater than value. Printing
     * and writing all indices to the console screen and file OUTPUT4.TXT separated by space.
     *
     * @param arr   Input array using for searching
     * @param value The value for searching
     */

    public void search(float arr[], float value) throws IOException {
        //Mở file
        FileWriter writer = new FileWriter("OUTPUT4.TXT");
        BufferedWriter buffer = new BufferedWriter(writer);
        System.out.print("Chỉ số là: ");
        buffer.write("Chỉ số là: ");//in kết quả tìm kiếm vào file OUTPUT4.TXT
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > value) {
                System.out.print(i + " ");
                buffer.write(i + " ");//in kết quả tìm kiếm vào file OUTPUT4.TXT
            }
        }
        buffer.close();//Đóng file
    }

    /**
     * Searching by using the Binary Search algorithm. Returning the first index of
     * value if it is present in array arr, otherwise, return -1. The index also
     * written to file OUTPUT5.TXT and shown on the console screen.
     *
     * @param arr   Input array using for searching
     * @param left  The left index
     * @param right The right index
     * @param value The value for searching
     * @return The index of the element if found, otherwise, return -1
     */

    public int binarySearch(float arr[], int left, int right, float value) throws IOException {
        //Mở file
        FileWriter writer = new FileWriter("OUTPUT5.TXT");
        BufferedWriter buffer = new BufferedWriter(writer);

        //lưu giá trị vào mảng b
        float[] b = new float[arr.length];
        for (int i = 0; i < arr.length; i++) b[i] = arr[i];

        //sắp xếp trên mảng b theo Selection Sort
        for (int i = 0; i < b.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < b.length; j++)
                if (b[j] < b[min]) min = j;
            swap(b, min, i);
        }

        while (left < right) {
            int mid = (left + right) / 2;// Chỉ số ở giữa mảng

            // Nếu phần tử lớn hơn chỉ số ở giữa, thì nó chỉ có thể
            // hiện diện trong mảng con bên phải
            if (value > b[mid]) left = mid + 1;

                // Ngược lại, phần tử chỉ có thể có mặt
                // trong mảng con bên phải kể cả right
            else right = mid;
        }

        //Tìm phần tử đầu tiên
        if (value == b[left]) {
            buffer.write("Index of first element: " + left);//in kết quả tìm kiếm vào file OUTPUT5.TXT
            buffer.close();//Đóng file
            return left;
        }

        return -1;//Trả về -1 nếu không tìm thấy phần tử
    }

}