package budgetbook.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.List;

@XmlRootElement(name = "entries")
@XmlSeeAlso({TableDataRow.class})
public class TableDataWrapper {

    private List<TableDataRow> entries;

    //  Einzelnes Element
    @XmlElement(name = "entry")
    public List<TableDataRow> getEntries() {
        return entries;
    }

    public void setEntries(List<TableDataRow> entries) {
        this.entries = entries;
    }
}
