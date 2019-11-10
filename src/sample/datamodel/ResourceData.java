package sample.datamodel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ResourceData {
    private static ResourceData instance = new ResourceData();

    private ObservableList<String> betonList;
    private ObservableList<String> diameterList;
    private final String[][] overlapGood = {                //[dn][concreteClass]
            /*dn8 */{"62","53","48","43","38","35","33"},
            /*dn10*/{"78","66","60","54","47","44","41"},
            /*dn12*/{"94","80","72","65","57","52","49"},
            /*dn14*/{"109","93","84","76","66","61","57"},
            /*dn16*/{"125","106","96","87","75","70","64"},
            /*dn20*/{"156","133","120","109","94","87","81"},
            /*dn26*/{"203","173","155","141","123","114","106"},
            /*dn30*/{"234","199","179","168","142","131","122"},
            /*dn36*/{"293","248","223","202","170","165","154"},
    };
    private final String[][] overlapBad = {                //[dn][concreteClass]
            /*dn8 */{"90","75","68","62","55","51","48"},
            /*dn10*/{"112","94","85","78","69","64","60"},
            /*dn12*/{"134","113","102","94","83","77","72"},
            /*dn14*/{"157","132","120","109","97","90","84"},
            /*dn16*/{"179","151","137","125","110","102","96"},
            /*dn20*/{"224","189","171","156","138","128","120"},
            /*dn26*/{"291","245","222","203","179","166","155"},
            /*dn30*/{"336","283","256","244","207","192","179"},
            /*dn36*/{"430","359","323","293","248","239","223"},
    };
    private final String[][] anchorageGood = {                //[dn][concreteClass]
            /*dn8 */{"42","35","32","29","25","23","22"},
            /*dn10*/{"52","44","40","36","31","29","27"},
            /*dn12*/{"62","53","48","43","38","35","33"},
            /*dn14*/{"73","62","56","51","44","41","38"},
            /*dn16*/{"83","71","64","58","50","60","43"},
            /*dn20*/{"104","89","80","72","63","58","54"},
            /*dn26*/{"135","115","104","94","82","76","71"},
            /*dn30*/{"156","133","120","109","94","87","81"},
            /*dn36*/{"196","165","148","134","120","110","102"},
    };
    private final String[][] anchorageBad = {                //[dn][concreteClass]
            /*dn8 */{"60","50","46","42","37","34","32"},
            /*dn10*/{"75","63","57","52","46","43","40"},
            /*dn12*/{"90","75","68","62","55","51","48"},
            /*dn14*/{"105","88","80","73","64","60","56"},
            /*dn16*/{"120","101","91","83","74","68","64"},
            /*dn20*/{"149","126","114","104","92","85","80"},
            /*dn26*/{"194","164","148","135","120","111","104"},
            /*dn30*/{"224","189","171","156","138","128","120"},
            /*dn36*/{"287","239","215","196","172","159","148"},
    };

    public static ResourceData getInstance(){
        return instance;
    }

    private ResourceData(){
        betonList = FXCollections.observableArrayList();
        betonList.add("C20/25");
        betonList.add("C25/30");
        betonList.add("C30/37");
        betonList.add("C35/45");
        betonList.add("C40/50");
        betonList.add("C45/55");
        betonList.add("C50/60");

        diameterList = FXCollections.observableArrayList();
        diameterList.add("8");
        diameterList.add("10");
        diameterList.add("12");
        diameterList.add("14");
        diameterList.add("16");
        diameterList.add("20");
        diameterList.add("26");
        diameterList.add("30");
        diameterList.add("36");

    }

    public String getOverlapGoodValue(int row, int column) {
        return overlapGood[row][column];
    }
    public String getOverlapBadValue(int row, int column) {
        return overlapBad[row][column];
    }
    public String getAnchorageGoodValue(int row, int column) {
        return anchorageGood[row][column];
    }
    public String getAnchorageBadValue(int row, int column) {
        return anchorageBad[row][column];
    }

    public ObservableList<String> getBetonList() {
        return betonList;
    }

    public ObservableList<String> getDiameterList() {
        return diameterList;
    }
}
