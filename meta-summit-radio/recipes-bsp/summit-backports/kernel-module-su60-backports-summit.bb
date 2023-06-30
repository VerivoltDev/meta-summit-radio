SUMMARY = "Summit Backports for SU60"

BACKPORTS_CONFIG = "${@bb.utils.contains('DISTRO_FEATURES','bluetooth','summit60','summit60_nbt',d)}"

RCONFLICTS:${PN} = " \
        kernel-module-st60-backports-summit \
        kernel-module-lwb-backports-summit \
        kernel-module-lwb5p-backports-summit \
        "

require summit-backports.inc radio-stack-su60-version.inc
