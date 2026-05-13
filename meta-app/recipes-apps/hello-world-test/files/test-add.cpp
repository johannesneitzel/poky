#include <gtest/gtest.h>

extern "C" {
#define main _hello_main
#include "hello-world.c"
#undef main
}

TEST(AddTest, PositiveNumbers) {
    EXPECT_EQ(5, add(2, 3));
    EXPECT_EQ(100, add(1, 99));
}

TEST(AddTest, Zero) {
    EXPECT_EQ(0, add(0, 0));
    EXPECT_EQ(7, add(7, 0));
    EXPECT_EQ(7, add(0, 7));
}

TEST(AddTest, NegativeNumbers) {
    EXPECT_EQ(-5, add(-2, -3));
    EXPECT_EQ(-1, add(-3, 2));
    EXPECT_EQ(0,  add(-5, 5));
}

int main(int argc, char **argv)
{
    ::testing::InitGoogleTest(&argc, argv);
    return RUN_ALL_TESTS();
}
