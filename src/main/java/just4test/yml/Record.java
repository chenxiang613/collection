package just4test.yml;

/**
 * @program: collectionIdea
 * @description: no
 * @author: chenxiang
 * @create: 2019-09-07 14:21
 **/
public class Record {
    @ValidateGZCB(dataType = ValidateGZCB.DataType.DICTIONARY,necessary = ValidateGZCB.NecessaryEnum.N)
    private String direction;
    @ValidateGZCB(dataType = ValidateGZCB.DataType.NUMBER_AND_CHARACTER,limit = 12,necessary = ValidateGZCB.NecessaryEnum.Y)
    private String userName;
    @ValidateGZCB(dataType = ValidateGZCB.DataType.AMOUNT,limit = 13,necessary = ValidateGZCB.NecessaryEnum.Y)
    private String amount;
    @ValidateGZCB(dataType = ValidateGZCB.DataType.NUMBER,limit = 16,necessary = ValidateGZCB.NecessaryEnum.Y)
    private String cardNbr;
    @ValidateGZCB(dataType = ValidateGZCB.DataType.DATE,limit = 8,necessary = ValidateGZCB.NecessaryEnum.Y)
    private String adjustmentDate;
    @ValidateGZCB(dataType = ValidateGZCB.DataType.NUMBER,limit = 4)
    private String noAnnotationMember;

    public String getAdjustmentDate() {
        return adjustmentDate;
    }

    public void setAdjustmentDate(String adjustmentDate) {
        this.adjustmentDate = adjustmentDate;
    }

    public String getDirection() {
        return direction;
    }

    public String getUserName() {
        return userName;
    }

    public String getAmount() {
        return amount;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCardNbr() {
        return cardNbr;
    }

    public void setCardNbr(String cardNbr) {
        this.cardNbr = cardNbr;
    }

    public String getNoAnnotationMember() {
        return noAnnotationMember;
    }

    public void setNoAnnotationMember(String noAnnotationMember) {
        this.noAnnotationMember = noAnnotationMember;
    }


    @Override
    public String toString() {
        return "Record{" +
                "direction='" + direction + '\'' +
                ", userName='" + userName + '\'' +
                ", amount='" + amount + '\'' +
                ", cardNbr='" + cardNbr + '\'' +
                ", noAnnotationMember='" + noAnnotationMember + '\'' +
                '}';
    }

    public String toStringLine() {
        return direction + userName + amount + cardNbr;
    }
}
