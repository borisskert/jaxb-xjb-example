package de.adorsys.examples.jaxb;

import com.googlecode.catchexception.apis.CatchExceptionHamcrestMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.googlecode.catchexception.CatchException.catchException;
import static com.googlecode.catchexception.CatchException.caughtException;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class NullableIntAdapterTest {

    private NullableIntAdapter adapter;

    @Before
    public void setup() throws Exception {
      adapter = new NullableIntAdapter();
    }

    @Test
    public void shouldMarshalNullToNull() throws Exception {
      assertThat(adapter.marshal(null), is(nullValue()));
    }

    @Test
    public void shouldMarshalSimpleNumberToString() throws Exception {
      assertThat(adapter.marshal(123), is(equalTo("123")));
    }

    @Test
    public void shouldUnmarshalNullToNull() throws Exception {
      assertThat(adapter.unmarshal(null), is(equalTo(null)));
    }

    @Test
    public void shouldUnmarshalEmptyToNull() throws Exception {
      assertThat(adapter.unmarshal(""), is(equalTo(null)));
    }

    @Test
    public void shouldUnmarshalSimpleTextNumberToNumber() throws Exception {
      assertThat(adapter.unmarshal("123"), is(equalTo(123)));
    }

    @Test
    public void shouldNotUnmarshalAnyNonNumberText() throws Exception {
        catchException(adapter).unmarshal("abc");
        Assert.assertThat(caughtException(), instanceOf(NumberFormatException.class));
    }

}