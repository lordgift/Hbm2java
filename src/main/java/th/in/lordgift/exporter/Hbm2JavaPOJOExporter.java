/**
 * Copyright (C) 2015 WaveMaker, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package th.in.lordgift.exporter;

/**
 * Created by sunil kumar
 */

import java.io.File;

import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.reveng.dialect.MetaDataDialect;
import org.hibernate.tool.hbm2x.POJOExporter;

public class Hbm2JavaPOJOExporter extends POJOExporter {

    private static final String WM_POJO_JAVA_CLASS_FTL = "pojo/Pojo.ftl";

    private MetaDataDialect metaDataDialect;

    public Hbm2JavaPOJOExporter(Configuration cfg, File outputDir, MetaDataDialect metaDataDialect) {
        super(cfg, outputDir);
        this.metaDataDialect = metaDataDialect;
        init();
    }

    protected void init() {
        setTemplateName(WM_POJO_JAVA_CLASS_FTL);
        setFilePattern("{package-name}/{class-name}.java");
    }

    public Hbm2JavaPOJOExporter(MetaDataDialect metaDataDialect) {
        this.metaDataDialect = metaDataDialect;
        init();
    }

    public String getName() {
        return "WMHbm2java";
    }

}
