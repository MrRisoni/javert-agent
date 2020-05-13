const { exec } = require("child_process");
var endOfLine = require('os').EOL;


module.exports = class Linux {
  constructor(settings) {
    this.settings = settings;
  }

  getKernelVersion() {
    return new Promise((resolve, reject) =>{
      exec("uname -r", (error, stdut, stderr) => {
        resolve(stdut);
      });
    });
  }

  getPartitionSpace() {
    return new Promise((resolve, reject) => {
      exec("df -h", (error, stdut, stderr) => {
        console.log(stdut.split(endOfLine));
        resolve(stdut);
      });
    });
  }

	listInstalledPackages(){
	var count_packages = settings.installed_packages + " | wc -l";
		return new Promise((resolve,reject) => {
exec(settings.installed_packages, (error, stout, stderr) => {
  resolve(stout);
});
});



	}

  parseFsTab() {}
};
