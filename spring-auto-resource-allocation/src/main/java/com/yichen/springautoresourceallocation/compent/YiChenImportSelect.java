package com.yichen.springautoresourceallocation.compent;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class YiChenImportSelect implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{"com.yichen.springautoresourceallocation.compent.YiChenServerImp"};
    }
}
