package org.hpi.esb.datasender

import org.hpi.esb.commons.util.Logging
import org.hpi.esb.datasender.config.ConfigHandler

object Main extends Logging {

  def main(args: Array[String]): Unit = {
    logger.info("args: " + args.mkString(" "))
    logger.info("Starting Datasender...")
      setLogLevel(ConfigHandler.config.verbose)
      new DataDriver().run()
  }

  def setLogLevel(verbose: Boolean): Unit = {
    if (verbose) {
      Logging.setToDebug
      logger.info("DEBUG/VERBOSE mode switched on")
    }
  }
}
