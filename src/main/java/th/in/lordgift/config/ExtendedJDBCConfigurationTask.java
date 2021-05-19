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
package th.in.lordgift.config;

import java.io.File;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.ant.JDBCConfigurationTask;

/**
 * User: sunil kumar
 */
public class ExtendedJDBCConfigurationTask extends JDBCConfigurationTask {


    public ExtendedJDBCConfigurationTask(File configurationFile) {
        super();
        setConfigurationFile(configurationFile);
    }

    @Override
    protected Configuration createConfiguration() {
        return new ExtendedJDBCMetaDataConfigration();
    }
}