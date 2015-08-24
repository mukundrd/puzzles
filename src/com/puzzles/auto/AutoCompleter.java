
package com.puzzles.auto;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public abstract class AutoCompleter {

    private static AutoCompleterImpl INSTANCE;

    public abstract List<String> findMatchingUrls(final String inputUrl);

    public abstract void addToCache(String url);

    public abstract void addToCache(List<String> urls);

    public abstract void clearCache();

    private static class AutoCompleterImpl extends AutoCompleter {

        private final TreeSet<String> mUrls;

        AutoCompleterImpl(List<String> urls) {
            mUrls = new TreeSet<String>(urls);
        }

        public List<String> findMatchingUrls(final String inputUrl) {

            final String lUrl = inputUrl; // .toLowerCase();

            final List<String> matches = new ArrayList<String>();

            for (String url : mUrls) {
                if (url.contains(lUrl)) {
                    matches.add(url);
                }
            }
            return matches;
        }

        public void addToCache(String url) {
            mUrls.add(url);
        }

        @Override
        public void addToCache(List<String> urls) {
            mUrls.addAll(urls);
        }

        @Override
        public void clearCache() {
            mUrls.clear();
        }
    }

    public static synchronized AutoCompleter getAutoCompleter(List<String> cachedUrls) {
        if (INSTANCE == null) {
            INSTANCE = new AutoCompleterImpl(cachedUrls);
        }
        return INSTANCE;
    }
}
