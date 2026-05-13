SUMMARY = "Google C++ Testing Framework"
HOMEPAGE = "https://github.com/google/googletest"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=cbbd27594afd089daa160d3a16dd515a"

SRC_URI = "git://github.com/google/googletest.git;protocol=https;branch=v1.12.x"
SRCREV = "58d77fa8070e8cec2dc1ed015d66b454c8d78850"

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE = "-DBUILD_SHARED_LIBS=ON \
                 -DINSTALL_GTEST=ON"

FILES:${PN}-dev += "${includedir}"
