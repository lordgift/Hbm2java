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
package com.hibernate.config;

import org.hibernate.cfg.JDBCMetaDataConfiguration;
import org.hibernate.cfg.JDBCReaderFactory;
import org.hibernate.cfg.MetaDataDialectFactory;
import org.hibernate.cfg.reveng.DatabaseCollector;
import org.hibernate.cfg.reveng.JDBCReader;
import org.hibernate.cfg.reveng.MappingsDatabaseCollector;
import org.hibernate.cfg.reveng.ReverseEngineeringRuntimeInfo;
import org.hibernate.cfg.reveng.dialect.MetaDataDialect;
import org.hibernate.engine.jdbc.spi.JdbcServices;

/**
 * User: sunil kumar
 */
public class ExtendedJDBCMetaDataConfigration extends JDBCMetaDataConfiguration {


    public MetaDataDialect getConfiguredMetaDataDialect(){

        JDBCReader reader = JDBCReaderFactory.newJDBCReader(this.getProperties(), buildSettings(), this.getReverseEngineeringStrategy(), this.getServiceRegistry());
        DatabaseCollector dbs = new MappingsDatabaseCollector(createMappings(), reader.getMetaDataDialect());
        JdbcServices service = this.getServiceRegistry().getService(JdbcServices.class);
        ReverseEngineeringRuntimeInfo info =  ReverseEngineeringRuntimeInfo.createInstance(service.getConnectionProvider(), service.getSqlExceptionHelper().getSqlExceptionConverter(), dbs);

        MetaDataDialect metaDataDialect = new MetaDataDialectFactory().createMetaDataDialect(service.getDialect(), this.getProperties());
        metaDataDialect.configure(info);
        return  metaDataDialect;

    }


}
