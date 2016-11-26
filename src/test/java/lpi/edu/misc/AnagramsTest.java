package lpi.edu.misc;

import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("unchecked")
public class AnagramsTest {

    private Anagrams sut = new Anagrams();

    @Test
    public void shouldFindNoAnagramsOnEmptyList() throws Exception {
        //when
        Set<Set<String>> result = sut.findAnagrams(new LinkedList<>());
        //then
        assertThat(result).isEmpty();
    }

    @Test
    public void shouldFindTwoAnagrams() throws Exception {
        //given
        LinkedList<String> input = list("ai", "ia");
        //when
        Set<Set<String>> result = sut.findAnagrams(input);
        //then

        assertThat(result).hasSize(1);
        assertThat(result.iterator().next()).containsExactlyElementsOf(Arrays.asList("ai", "ia"));
    }

    @Test
    public void shouldFindTwoSetsOfAnagrams() throws Exception {
        //given
        LinkedList<String> input = list("abc", "cba", "xya", "www", "bca", "afawfe", "aagrwegfea", "yax");
        //when
        Set<Set<String>> result = sut.findAnagrams(input);
        //then

        assertThat(result).hasSize(2);
        Iterator<Set<String>> it = result.iterator();
        assertThat(it.next()).containsExactly("bca", "abc", "cba");
        assertThat(it.next()).containsExactly("xya", "yax");
    }

    private LinkedList<String> list(String ... args){
        LinkedList<String> result = new LinkedList<>();
        Collections.addAll(result, args);
        return result;
    }
}