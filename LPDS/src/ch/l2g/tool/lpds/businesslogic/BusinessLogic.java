package ch.l2g.tool.lpds.businesslogic;

import ch.l2g.tool.lpds.gui.Controller.interfaces.FrontGuiProvider;
import ch.l2g.tool.lpds.gui.Controller.interfaces.StrategyProvider;
import ch.l2g.tool.lpds.svg.XmlCreator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BusinessLogic implements FrontGuiProvider, StrategyProvider {
    private static Logger logger = LoggerFactory.getLogger(BusinessLogic.class);

    public BusinessLogic() {

    }



    @Override
    public void setText(String name1, String name2, String summe, String child, String address, boolean hasChild, boolean hasHouse) {
        XmlCreator xmlCreator = new XmlCreator(name1,name2,summe,child,address,hasChild,hasHouse);
    }

    @Override
    public void changeStrategy() {
        System.out.println("Strategie gewechselt");
    }
}
