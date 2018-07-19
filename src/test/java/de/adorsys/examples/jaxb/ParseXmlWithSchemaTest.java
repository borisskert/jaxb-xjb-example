package de.adorsys.examples.jaxb;

import de.adorsys.examples.jaxb.generated.ObjectFactory;
import de.adorsys.examples.jaxb.generated.Triangle;
import de.adorsys.examples.jaxb.generated.Triangles;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class ParseXmlWithSchemaTest {

    private Triangles triangles;

    @Before
    public void setup() throws Exception {
        JAXBContext jc = JAXBContext.newInstance(ObjectFactory.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        ClassLoader classLoader = getClass().getClassLoader();

        File file = new File(classLoader.getResource("xml/test.xml").getFile());
        triangles = (Triangles) unmarshaller.unmarshal(file);
    }

    @Test
    public void shouldHaveSizeOfOne() throws Exception {
        List<Triangle> triangles = this.triangles.getTriangle();
        assertThat(triangles.size(), is(equalTo(1)));
    }

    @Test
    public void shouldHaveRightCoordinatesOne() throws Exception {
        List<Triangle> triangles = this.triangles.getTriangle();
        Triangle triangle = triangles.get(0);

        assertThat(triangle.getA().getX(), is(equalTo(123)));
        assertThat(triangle.getA().getY(), is(equalTo(987)));
        assertThat(triangle.getA().getZ(), is(equalTo(546)));

        assertThat(triangle.getB().getX(), is(equalTo(234)));
        assertThat(triangle.getB().getY(), is(equalTo(876)));
        assertThat(triangle.getB().getZ(), is(equalTo(666)));

        assertThat(triangle.getC().getX(), is(equalTo(345)));
        assertThat(triangle.getC().getY(), is(equalTo(765)));
        assertThat(triangle.getC().getZ(), is(equalTo(000)));
    }
}
