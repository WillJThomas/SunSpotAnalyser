package org.willjt.analyser;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class IntegerGridValueTransformerTest {

    private IntegerGridValueTransformer transformer;

    @Before
    public void instantiateTransformer() {
        transformer = new IntegerGridValueTransformer();
    }

    @Test
    public void transformsAnEmptyListToAnEmptyListOfTheCorrectType() throws Exception {
        List<Integer> emptyList = new ArrayList<Integer>();
        int valuesPerRow = 0;

        List<IntegerGridValue> result = transformer.fromListOfValues(emptyList, valuesPerRow);

        assertThat(result.isEmpty(), is(true));
    }
    
    
}