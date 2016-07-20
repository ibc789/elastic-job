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

package com.dangdang.ddframe.job.cloud.context;

import com.dangdang.ddframe.job.cloud.config.CloudJobConfiguration;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public final class JobContextTest {
    
    @Test
    public void assertFrom() {
        CloudJobConfiguration jobConfig = new CloudJobConfiguration("test_job", "5/10 * * * * *", 10, 1.0d, 128.0d, "dockerImage", "http://localhost/app.jar", true, true, false);
        JobContext actual = JobContext.from(jobConfig, ExecutionType.READY);
        assertThat(actual.getAssignedShardingItems().size(), is(10));
        for (int i = 0; i < actual.getAssignedShardingItems().size(); i++) {
            assertThat(actual.getAssignedShardingItems().get(i), is(i));
        }
    }
}
