package edu.iis.mto.bsearch;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SearchResultTest {

    @Test
    public void isFoundShouldReturnTrueForPosition0(){
        final SearchResult sut = new SearchResult();
        sut.setPosition(0);
        assertThat(sut.isFound(), is(true));
    }


    @Test
    public void isFoundShouldReturnTrueForPosition1(){
        final SearchResult sut = new SearchResult();
        sut.setPosition(1);
        assertThat(sut.isFound(), is(true));
    }
}