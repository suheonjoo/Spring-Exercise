package me.whiteship.refactoring._13_loop._33_replace_loop_with_pipeline._02_after;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Author {

    private String company;

    private String twitterHandle;

    public Author(String company, String twitterHandle) {
        this.company = company;
        this.twitterHandle = twitterHandle;
    }

    static public List<String> TwitterHandles(List<Author> authors, String company) {
        var result = new ArrayList<String> ();

        return authors.stream()
                .filter(a -> a.company.equals(company))
                .map(author -> author.twitterHandle)
                .filter(Objects::nonNull) //.filter(t -> t != null)
                .collect(Collectors.toList());
//
//        for (Author a : authors) {
//            if (a.company.equals(company)) {
//                var handle = a.twitterHandle;
//                if (handle != null)
//                    result.add(handle);
//            }
//        }
//        return result;
    }

}
