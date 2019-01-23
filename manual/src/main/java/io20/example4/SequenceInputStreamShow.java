package io20.example4;

import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.List;

public class SequenceInputStreamShow implements Enumeration<FileInputStream> {
    private Enumeration<String> files;

    public SequenceInputStreamShow(List<String> files) {

    }
}
