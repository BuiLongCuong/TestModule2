import java.util.ArrayList;

public class ProductManager {
    private ArrayList<Product> list = new ArrayList<>();
    private ReadAndWriteFile readAndWriteFile;

    public ProductManager() {
        readAndWriteFile = new ReadAndWriteFile();
        this.list = readAndWriteFile.readFile();
    }

    public void add(Product newProduct){
        list.add(newProduct);
        readAndWriteFile.writeFile(list);
    }
    public void showAll(){
        for (Product product : list) {
            System.out.println(product);
        }
    }
    public int checkId(int id){
        for (Product product : list) {
            if(product.getId()==id){
                return product.getId();
            }
        }
        return -1;
    }
    public void edit(int id, String name, int quantity, int price, String typeOfProduct){
            for (Product product : list) {
                if(product.getId() == id){
                    product.setId(id);
                    product.setName(name);
                    product.setQuantity(quantity);
                    product.setPrice(price);
                    product.setTypeOfProduct(typeOfProduct);
                }
            }
        readAndWriteFile.writeFile(list);
    }
    public void delete(int id){
        list.remove(id-1);
        readAndWriteFile.writeFile(list);
    }
    public Product findProductById(int id){
        for (Product product : list) {
            if(product.getId() == id){
                return product;
            }
        }
        return null;
    }
    public ArrayList<Product> searchStudentByName(String name){
        ArrayList<Product> listSearch = new ArrayList<>();
        for (Product product : list) {
            if(product.getName().toLowerCase().contains(name.toLowerCase())){
                listSearch.add(product);
            }
        }
        return listSearch;
    }
    public ArrayList<Product> listGoodProducts(){
        ArrayList<Product> list1 = new ArrayList<>();
        for (Product product : list) {
            if(product.getTypeOfProduct().equals("Tốt")){
                list1.add(product);
            }
        }
        return list1;
    }
    public ArrayList<Product> listMediumProducts(){
        ArrayList<Product> list2 = new ArrayList<>();
        for (Product product : list) {
            if(product.getTypeOfProduct().equals("Trung bình")){
                list2.add(product);
            }
        }
        return list2;
    }
    public ArrayList<Product> listBadProducts(){
        ArrayList<Product> list3 = new ArrayList<>();
        for (Product product : list) {
            if(product.getTypeOfProduct().equals("Kém")){
                list3.add(product);
            }
        }
        return list3;
    }
}
