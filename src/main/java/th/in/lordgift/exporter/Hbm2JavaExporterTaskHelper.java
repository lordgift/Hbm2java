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

import org.hibernate.cfg.reveng.dialect.MetaDataDialect;
import org.hibernate.tool.ant.Hbm2JavaExporterTask;
import org.hibernate.tool.ant.HibernateToolTask;
import org.hibernate.tool.hbm2x.Exporter;

/**
 * User: sunil kumar
 */
public class Hbm2JavaExporterTaskHelper extends Hbm2JavaExporterTask {

    private MetaDataDialect metaDataDialect;

    public Hbm2JavaExporterTaskHelper(HibernateToolTask parent, MetaDataDialect metaDataDialect) {
        super(parent);
        this.metaDataDialect = metaDataDialect;
    }

    public MetaDataDialect getMetaDataDialect() {
        return metaDataDialect;
    }

    protected Exporter createExporter() {
        return new Hbm2JavaPOJOExporter(getMetaDataDialect());
    }

    public String getName() {
        return "WM hbm2java (Generates a set of .java files)";
    }
}
