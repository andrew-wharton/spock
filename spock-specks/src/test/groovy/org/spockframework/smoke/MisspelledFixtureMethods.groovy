/*
 * Copyright 2009 the original author or authors.
 *
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
 */

package org.spockframework.smoke

import org.spockframework.EmbeddedSpecification
import org.spockframework.util.SpockSyntaxException

/**
 * @author Peter Niederwieser
 */
class MisspelledFixtureMethods extends EmbeddedSpecification {
  def "misspelled setup causes compile error"() {
    when:
    compiler.compileSpeckBody("""
def setUp() {}
    """)

    then:
    thrown(SpockSyntaxException)
  }

  def "misspelled cleanup causes compile error"() {
    when:
    compiler.compileSpeckBody("""
def cLeanup() {}
    """)

    then:
    thrown(SpockSyntaxException)
  }

  def "misspelled setupSpeck causes compile error"() {
    when:
    compiler.compileSpeckBody("""
def setupspeck() {}
    """)

    then:
    thrown(SpockSyntaxException)
  }

  def "misspelled cleanupSpeck causes compile error"() {
    when:
    compiler.compileSpeckBody("""
def CleanupSpeck() {}
    """)

    then:
    thrown(SpockSyntaxException)
  }

  def "correctly spelled setup compiles successfully"() {
    when:
    compiler.compileSpeckBody("""
  def setup() {}
    """)

    then:
    noExceptionThrown()
  }
}