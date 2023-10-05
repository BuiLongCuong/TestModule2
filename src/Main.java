import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ProductManager productManager = new ProductManager();
        productManager.add(new Product("cà phê", 50, 25000, "Tốt"));
        productManager.add(new Product("trà đá", 100, 5000, "Tốt"));
        productManager.add(new Product("trà đào", 90, 20000, "Tốt"));
        productManager.add(new Product("bạc sỉu", 70, 20000, "Tốt"));
        productManager.add(new Product("trà tắc", 100, 10000, "Tốt"));
        productManager.showAll();
        int choice;
        do {
            System.out.println("MENU QUẢN LÍ SẢN PHẨM");
            System.out.println("1.Thêm mới sản phẩm.");
            System.out.println("2.Sửa sản phẩm theo id.");
            System.out.println("3.Xóa sản phẩm theo id.");
            System.out.println("4.Hiển thị danh sách sản phẩm.");
            System.out.println("5.Tìm kiếm các sản phẩm theo tên gần đúng.");
            System.out.println("6.Nhập vào loại sản phẩm và lấy ra tất cả sản phẩm cùng loại.");
            System.out.println("7.Tìm sản phẩm theo id.");
            System.out.println("0.Thoát");
            choice = input.nextInt();
            switch (choice){
                case 1:
                    menuAdd(productManager);
                    break;
                case 2:
                    menuEdit(productManager);
                    break;
                case 3:
                    menuDelete(productManager);
                    break;
                case 4:
                    productManager.showAll();
                    break;
                case 5:
                    menuSearchStudentByName(productManager);
                    break;
                case 6:
                    int choiceListTypeProduct;
                    do {
                        System.out.println("1.Danh sách các sản phẩm loại Tốt.");
                        System.out.println("2.Danh sách các sản phẩm loại Trung Bình.");
                        System.out.println("3.Danh sách các sản phẩm loại Kém.");
                        System.out.println("0.Quay lại.");
                        choiceListTypeProduct = input.nextInt();
                        switch (choiceListTypeProduct){
                            case 1:
                                ArrayList<Product> list1;
                                list1 = productManager.listGoodProducts();
                                for (Product product : list1) {
                                    System.out.println(product);
                                }
                                break;
                            case 2:
                                ArrayList<Product> list2;
                                list2 = productManager.listMediumProducts();
                                for (Product product : list2) {
                                    System.out.println(product);
                                }
                                break;
                            case 3:
                                ArrayList<Product> list3;
                                list3 = productManager.listBadProducts();
                                for (Product product : list3) {
                                    System.out.println(product);
                                }
                                break;
                        }
                    }while (choiceListTypeProduct!=0);
                    break;
                case 7:
                    menuFindStudentById(productManager);
                    break;
            }
        }while (choice!=0);
    }

    private static void menuFindStudentById(ProductManager productManager) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập id của sản phầm muốn tìm:");
        int id = input.nextInt();
        if( productManager.findProductById(id)==null){
            System.out.println("---------- Không có sản phẩm đó trong danh sách! ----------");
        }else {
            System.out.println(productManager.findProductById(id));
        }
    }

    private static void menuSearchStudentByName(ProductManager productManager) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập tên sản phẩm cần tìm:");
        String searchName = input.nextLine();
        if(productManager.searchStudentByName(searchName).isEmpty()){
            System.out.println("---------- Không có sản phẩm đó trong danh sách! ----------");
        }else {
            ArrayList<Product> list = productManager.searchStudentByName(searchName);
            for (Product product : list) {
                System.out.println(product);
            }
        }
    }

    private static void menuDelete(ProductManager productManager) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập id của sản phẩm bạn muốn xóa:");
        int idDelete = input.nextInt();
        if(productManager.checkId(idDelete)!=-1){
            productManager.delete(idDelete);
            System.out.println("--------- Xóa thành công! ----------");
        }else {
            System.out.println("---------- Không có sản phẩm đó! ----------");
        }
    }

    private static void menuEdit(ProductManager productManager) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập id của sản phẩm bạn muốn sửa:");
        int idEdit = input.nextInt();
        if(productManager.checkId(idEdit)!=-1){
            input.nextLine();
            System.out.println("Nhập tên bạn muốn sửa:");
            String editName = input.nextLine();
            System.out.println("Nhập số lượng bạn muốn sửa:");
            int editQuantity = input.nextInt();
            System.out.println("Nhập giá cả bạn muốn sửa:");
            int editPrice = input.nextInt();
            input.nextLine();
            System.out.println("Nhập loại bạn muốn sửa:");
            String editTypeOfProduct = input.nextLine();
            productManager.edit(idEdit,editName,editQuantity,editPrice,editTypeOfProduct);
            System.out.println("---------- Sửa thành công! ----------");
        }else {
            System.out.println("---------- Không có sản phẩm đó! ----------");
        }
    }

    private static void menuAdd(ProductManager productManager) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập tên sản phẩm mới:");
        String newName = input.nextLine();
        System.out.println("Nhập số lượng của sản phẩm mới:");
        int newQuantity = input.nextInt();
        System.out.println("Nhập giá của sản phẩm mới:");
        int newPrice = input.nextInt();
        input.nextLine();
        System.out.println("Nhập loại của sản phẩm mới(Tốt/Trung bình/Kém):");
        String newTypeOfProduct = input.nextLine();
        Product newProduct = new Product(newName, newQuantity, newPrice, newTypeOfProduct);
        productManager.add(newProduct);
        System.out.println("---------- Thêm thành công! ----------");
    }
}