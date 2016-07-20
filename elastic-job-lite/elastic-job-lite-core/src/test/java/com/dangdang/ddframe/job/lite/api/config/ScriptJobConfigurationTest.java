/*
 * Copyright 1999-2015 dangdang.com.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package com.dangdang.ddframe.job.lite.api.config;

import com.dangdang.ddframe.job.lite.api.config.impl.AbstractJobConfiguration;
import com.dangdang.ddframe.job.lite.api.config.impl.ScriptJobConfiguration;
import org.junit.Test;
import org.unitils.util.ReflectionUtils;

public final class ScriptJobConfigurationTest extends AbstractJobConfigurationTest<ScriptJobConfiguration, ScriptJobConfiguration.ScriptJobConfigurationBuilder> {
    
    @Override
    protected ScriptJobConfiguration getJobConfiguration() {
        return getJobConfigurationBuilder().build();
    }
    
    @Override
    protected ScriptJobConfiguration.ScriptJobConfigurationBuilder getJobConfigurationBuilder() {
        return new ScriptJobConfiguration.ScriptJobConfigurationBuilder("scriptJob", 10, "0/1 * * * * ?", "test.sh");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testBuildScriptJobConfigurationWithWrongScriptCommandLine() {
        AbstractJobConfiguration.AbstractJobConfigurationBuilder builder = getJobConfigurationBuilder();
        try {
            ReflectionUtils.setFieldValue(builder, ScriptJobConfiguration.ScriptJobConfigurationBuilder.class.getDeclaredField("scriptCommandLine"), "");
        } catch (final NoSuchFieldException ex) {
            ex.printStackTrace();
        }
        builder.build();
    }
}
