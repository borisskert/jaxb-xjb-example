package de.adorsys.examples.jaxb;


import de.adorsys.examples.jaxb.generated.Point;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class PointAdapter extends XmlAdapter<String, Point> {

    @Override
    public Point unmarshal(String v) throws Exception {
        String[] coords = v.split(",");
        Point point = new Point();

        point.setX(Integer.parseInt(coords[0]));
        point.setY(Integer.parseInt(coords[1]));

        return point;
    }

    @Override
    public String marshal(Point v) throws Exception {
        return String.format("%d,%d", v.getX(), v.getY());
    }
}
