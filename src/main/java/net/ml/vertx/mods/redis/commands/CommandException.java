/*
 * Copyright 2011-2012 the original author or authors.
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
package net.ml.vertx.mods.redis.commands;

/**
 * CommandExecption thrown by any error
 * <p>
 * 
 * @author <a href="http://marx-labs.de">Thorsten Marx</a>
 */
public class CommandException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1373570365074664728L;
	
	public CommandException () {
		super();
	}
	
	public CommandException (String message) {
		super(message);
	}
	public CommandException (String message, Throwable cause) {
		super(message, cause);
	}
	public CommandException (Throwable cause) {
		super(cause);
	}
}
