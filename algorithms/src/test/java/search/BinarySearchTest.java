package search;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

    BinarySearch binarySearch;

    @Before
    public void setUp() throws Exception {
        binarySearch = new BinarySearch();
    }

    @Test
    public void search() throws Exception {
        Assert.assertEquals(0, binarySearch.search(new Integer[]{1,2,3,4,5,6,7,8,9,10}, 1));
    }

}