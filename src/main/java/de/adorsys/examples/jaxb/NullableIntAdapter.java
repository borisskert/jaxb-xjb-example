package de.adorsys.examples.jaxb;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class NullableIntAdapter extends XmlAdapter<String, Integer> {

    @Override
    public Integer unmarshal(String v) throws Exception {
        if (v == null || v.trim().length() == 0) {
            return null;
        }

        return Integer.valueOf(v);
    }

    @Override
    public String marshal(Integer v) throws Exception {
        if (v == null) {
            return null;
        }

        return v.toString();
    }
}
