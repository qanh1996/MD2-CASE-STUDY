package service.receiptService;

import config.ConfigReadAndWriteFile;
import model.Receipt;
import model.Room;
import service.roomService.RoomServiceIMPL;

import java.util.List;

public class ReceiptServiceIMPL implements IReceiptService{
    public static String PATH_RECEIPT = "C:\\Users\\HP\\IdeaProjects\\MD2-case-study\\src\\data\\receiptData.txt";
    public static List<Receipt> receiptList = new ConfigReadAndWriteFile<Receipt>().readFromFile(PATH_RECEIPT);

    @Override
    public List<Receipt> findAll() {
        new ConfigReadAndWriteFile<Receipt>().writeToFile(PATH_RECEIPT, receiptList);
        return receiptList;
    }

    @Override
    public void save(Receipt receipt) {
        receiptList.add(receipt);
        new ConfigReadAndWriteFile<Receipt>().writeToFile(PATH_RECEIPT, receiptList);
    }

    @Override
    public void save() {
        new ConfigReadAndWriteFile<Receipt>().writeToFile(PATH_RECEIPT, receiptList);
    }

    @Override
    public void deleteByID(int id) {
        for (int i = 0; i < receiptList.size(); i++) {
            if (id == receiptList.get(i).getReceiptId()) {
                receiptList.remove(receiptList.get(i));
            }
        }
    }

    @Override
    public void editByID(int id) {

    }

    @Override
    public Receipt findByID(int id) {
        for (int i = 0; i < receiptList.size(); i++) {
            if (id == receiptList.get(i).getReceiptId()) {
                return receiptList.get(i);
            }
        }
        return null;
    }

    @Override
    public Receipt findReceiptByRoomId(int id) {
        Room room = new RoomServiceIMPL().findByID(id);
        int count = 0;
        for (int i = 0; i < receiptList.size(); i++) {
            if (receiptList.get(i).getRoom() == room) {
                count++;
                return receiptList.get(i);
            } else if (count == 0 && i == receiptList.size() - 1) {
                System.out.println("THIS ROOM DON'T HAVE RECEIPT");
            }
        }
        return null;
    }

    @Override
    public double getAllTotalPrice() {
        double total = 0;
        for (int i = 0; i < receiptList.size(); i++) {
            total += receiptList.get(i).getTotalPrice();
        }
        return total;
    }
}
