package com.coder.behzod.tetris.models

import com.coder.behzod.tetris.models.Frame


enum class Shape(val frameNumber: Int, val startPosition: Int) {

    Tetramino(2, 2) {

        override fun getFrame(frameNumber: Int): Frame {
            return when (frameNumber) {
                0 -> com.coder.behzod.tetris.models.Frame(4).addRow("1111")
                1 -> Frame(1)
                    .addRow("1")
                    .addRow("1")
                    .addRow("1")
                    .addRow("1")

                else -> throw IllegalArgumentException("${this.frameNumber} is an invalid frameNumber")
            }
        }

    },
    Tetramino1(1, 1) {
        override fun getFrame(frameNumber: Int): Frame {
            return Frame(2)
                .addRow("11")
                .addRow("11")
        }
    },
    Tetramino2(2, 1) {
        override fun getFrame(frameNumber: Int): Frame {
            return when (frameNumber) {
                0 -> Frame(3)
                    .addRow("110")
                    .addRow("011")

                1 -> Frame(2)
                    .addRow("01")
                    .addRow("11")
                    .addRow("10")

                else -> throw IllegalArgumentException("${this.frameNumber} is an invalid FrameNumber")
            }
        }
    },
    Tetramino3(2, 1) {
        override fun getFrame(frameNumber: Int): Frame {
            return when (frameNumber) {
                0 -> Frame(3)
                    .addRow("011")
                    .addRow("110")

                1 -> Frame(2)
                    .addRow("01")
                    .addRow("11")
                    .addRow("10")

                else -> throw IllegalArgumentException("${this.frameNumber} is an invalid FrameNumber")
            }
        }
    },
    Tetramino4(2, 2) {
        override fun getFrame(frameNumber: Int): Frame {
            return when (frameNumber) {
                0 -> Frame(4).addRow("1111")
                1 -> Frame(1)
                    .addRow("1")
                    .addRow("1")
                    .addRow("1")
                    .addRow("1")

                else -> throw IllegalArgumentException("${this.frameNumber} is an invalid FrameNumber")
            }
        }
    },
    Tetramino5(4, 1) {

        override fun getFrame(frameNumber: Int): Frame {
            return when (frameNumber) {
                0 -> Frame(3)
                    .addRow("010")
                    .addRow("111")

                1 -> Frame(2)
                    .addRow("10")
                    .addRow("11")
                    .addRow("10")

                2 -> Frame(3)
                    .addRow("111")
                    .addRow("010")

                3 -> Frame(2)
                    .addRow("01")
                    .addRow("11")
                    .addRow("01")

                else -> throw IllegalArgumentException("${this.frameNumber} is an invalid FrameNumber")
            }
        }

    },
    Tetramino6(4, 1) {
        override fun getFrame(frameNumber: Int): Frame {
            return when (frameNumber) {
                0 -> Frame(3)
                    .addRow("100")
                    .addRow("111")

                1 -> Frame(2)
                    .addRow("11")
                    .addRow("10")
                    .addRow("10")

                2 -> Frame(3)
                    .addRow("111")
                    .addRow("001")

                3 -> Frame(2)
                    .addRow("01")
                    .addRow("01")
                    .addRow("11")

                else -> throw IllegalArgumentException("${this.frameNumber} is an invalid FrameNumber")
            }
        }
    },
    Tetramino7(4, 1) {
        override fun getFrame(frameNumber: Int): Frame {
            return when (frameNumber) {
                0 -> Frame(3)
                    .addRow("001")
                    .addRow("111")

                1 -> Frame(2)
                    .addRow("10")
                    .addRow("10")
                    .addRow("11")

                2 -> Frame(3)
                    .addRow("111")
                    .addRow("100")

                3 -> Frame(2)
                    .addRow("11")
                    .addRow("01")
                    .addRow("01")

                else -> throw IllegalArgumentException("${this.frameNumber} is an invalid FrameNumber")
            }
        }
    };

    abstract fun getFrame(frameNumber: Int): Frame

}