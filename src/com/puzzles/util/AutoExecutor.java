
package com.puzzles.util;

import java.util.Arrays;
import java.util.List;

import com.puzzles.auto.AutoCompleter;

public class AutoExecutor {

    public static void main(String[] args) {

        List<String> cachedUrls = Arrays.asList("www.android.com", 
                "www.beatles.com", 
                "www.beatles.com/contact", 
                "www.beatles.com/about",
                "www.carbon.com", 
                "www.dolphins.com");

        AutoCompleter autoCompleter = AutoCompleter.getAutoCompleter(cachedUrls);

        List<String> matching = autoCompleter.findMatchingUrls("beatle");

        System.out.println(matching);
    }
}
