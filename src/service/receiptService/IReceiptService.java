package service.receiptService;

import model.Receipt;
import service.IGenericService;

public interface IReceiptService extends IGenericService<Receipt> {
    Receipt findReceiptByRoomId (int id);
    double getAllTotalPrice ();
    void save();
}
