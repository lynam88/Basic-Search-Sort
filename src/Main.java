import java.io.IOException;//Nạp Package chứa class xử lý ngoại lệ
import java.util.Scanner;//Nạp Package chứa class lấy đầu vào từ người dùng
import java.util.Random;//Nạp Package chứa class cung cấp các phương thức sinh số ngẫu nhiên

public class Main {

    static float[] a;// Khai báo mảng float a

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int choice;//Biến lưu lựa chọn chương trình của người dùng
        int n;//Biến lưu chiều dài mảng
        Algorithm algorithm = new Algorithm();//Tạo đối tượng để sử dụng các phương thức trong lớp Algorithm
        do {
            algorithm.menu();//Hiển thị menu chương trình
            System.out.print("Choice: ");
            choice = sc.nextInt();
            switch (choice) {

                //Nhập dữ liệu từ bàn phím
                case 1:
                    System.out.print("Input number of elements: ");
                    n = sc.nextInt();
                    a = new float[n];//Gán chiều dài mảng
                    System.out.print("Input elements: ");
                    for (int i = 0; i < n; i++) {
                        a[i] = sc.nextFloat();
                    }
                    algorithm.writeFile("INPUT.TXT", a);// lưu vào tệp INPUT.TXT.
                    break;

                //Đọc dữ liệu từ tệp lưu vào mảng
                case 2:
                    System.out.println("Read from file");
                    System.out.print("Array a: ");
                    a = algorithm.readFile("INPUT.TXT");//đọc dữ liệu từ file INPUT.TXT
                    for (int i = 0; i < a.length; i++) {
                        System.out.print(a[i] + " ");
                    }
                    System.out.println();
                    break;

                //Sắp xếp theo thuật toán Bubble Sort
                case 3:
                    try {
                        System.out.println("Bubble sort");
                        float[] b = algorithm.bubbleSort(a);//lưu mảng đã sắp xếp vào mảng mới để in
                        algorithm.writeFile("OUTPUT1.TXT", b);//in kết quả bước cuối cùng vào file OUTPUT1.TXT
                    } catch (Exception e) {
                        System.out.println("Vui lòng nhập mảng (Input) trước!");
                    }
                    ;
                    break;

                //Sắp xếp theo thuật toán Bubble Sort
                case 4:
                    try {
                        System.out.println("Selection sort");
                        float[] c = algorithm.selectionSort(a);
                        algorithm.writeFile("OUTPUT2.TXT", c);//in kết quả vào OUTPUT2.TXT
                    } catch (Exception e) {
                        System.out.println("Vui lòng nhập mảng (input) trước!");
                    }
                    ;
                    break;

                //Sắp xếp theo thuật toán Insertion sort
                case 5:
                    try {
                        System.out.println("Insertion sort");
                        float[] d = algorithm.insertionSort(a);
                        algorithm.writeFile("OUTPUT3.TXT", d);//in kết quả vào OUTPUT3.TXT
                    } catch (Exception e) {
                        System.out.println("Vui lòng nhập mảng (input) trước!");
                    }
                    ;
                    break;

                //Tìm kiếm theo thuật toán Tìm Kiếm Tuyến Tính (Linear Search)
                case 6:
                    try {
                        System.out.println("Linear Search");
                        System.out.print("Input value:");
                        float valueLinear = sc.nextInt();//Biến value người dùng nhập tìm kiếm
                        algorithm.search(a, valueLinear);//Tìm kiếm vị trí của các phần tử có giá trị lớn hơn biến value được nhập vào.
                    } catch (Exception e) {
                        System.out.println("Vui lòng nhập mảng (input) trước!");
                    }
                    ;
                    break;

                //Tìm kiếm theo thuật toán nhị phân
                case 7:
                    try {
                        System.out.println("Binary Search");
                        System.out.print("Input value:");
                        float valueBinary = sc.nextInt();//Biến value người dùng nhập tìm kiếm
                        System.out.print("Index of first element: ");
                        System.out.println(algorithm.binarySearch(a, 0, a.length - 1, valueBinary));//Tìm chỉ số phần tử đầu tiên có giá trị bằng value trên mảng được sắp xếp
                    } catch (Exception e) {
                        System.out.println("Vui lòng nhập mảng (input) trước!");
                    }
                    ;
                    break;

                case 8:
                    //So sánh thời gian chạy thuật toán với dữ liệu bằng thực nghiệm
                    System.out.println();
                    System.out.println("So sánh thời gian chạy thuật toán với dữ liệu bằng thực nghiệm");
                    Comparison compare = new Comparison();
                    System.out.print("Nhập độ dài mảng: ");
                    int length = sc.nextInt();
                    float[] b = new float[length];
                    float[] c = new float[length];
                    float[] d = new float[length];
                    Random random = new Random();

                    for (int i = 0; i < b.length; i++) {
                        b[i] = i;
                    }

                    for (int i = 0; i < c.length; i++) {
                        c[i] = c.length - 1 - i;
                    }

                    for (int i = 0; i < d.length; i++) {
                        d[i] = random.nextFloat();
                    }

                    //Chạy với giải thuật Bubble Sort
                    System.out.println();
                    System.out.println("1. Chạy với giải thuật Bubble Sort");
                    System.out.println();
                    System.out.println("Mảng tăng dần");
                    compare.bubbleSortCompare(b);
                    System.out.println("Mảng giảm dần");
                    compare.bubbleSortCompare(c);
                    System.out.println("Mảng ngẫu nhiên");
                    compare.bubbleSortCompare(d);

                    //Chạy với giải thuật Selection Sort
                    System.out.println();
                    System.out.println("2. Chạy với giải thuật Selection Sort");
                    System.out.println();
                    System.out.println("Mảng tăng dần");
                    compare.selectionSortCompare(b);
                    System.out.println("Mảng giảm dần");
                    compare.selectionSortCompare(c);
                    System.out.println("Mảng ngẫu nhiên");
                    compare.selectionSortCompare(d);

                    //Chạy với giải thuật Insertion Sort
                    System.out.println();
                    System.out.println("3. Chạy với giải thuật Insertion Sort");
                    System.out.println();
                    System.out.println("Mảng tăng dần");
                    compare.insertionSortCompare(b);
                    System.out.println("Mảng giảm dần");
                    compare.insertionSortCompare(c);
                    System.out.println("Mảng ngẫu nhiên");
                    compare.insertionSortCompare(d);

                    break;

                //Thoát chương trình
                case 0:
                    System.out.println("Thanks!!!");
                    break;
            }
        } while (choice != 0);

    }

}

