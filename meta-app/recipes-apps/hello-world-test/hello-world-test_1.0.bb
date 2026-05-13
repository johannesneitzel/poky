SUMMARY = "Unit tests for hello-world add()"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS = "googletest"

FILESEXTRAPATHS:prepend := "${THISDIR}/../hello-world/files:"

SRC_URI = "file://test-add.cpp \
           file://hello-world.c"

S = "${WORKDIR}"

do_compile() {
    ${CXX} ${CXXFLAGS} ${LDFLAGS} test-add.cpp -lgtest -lpthread -o hello-world-test
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 hello-world-test ${D}${bindir}/hello-world-test
}

RDEPENDS:${PN} = "googletest"
