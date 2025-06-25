---
layout: home
title: "Bingo Simulation Project"
heading: "Java Bingo Simulation"
subheading: "A comprehensive Bingo game simulation and card generator built with Java Swing"
---

<div class="space-y-12">
    <!-- Main Featured Demo GIF -->
    <div class="flex justify-center">
        <img class="object-cover object-top w-full max-w-4xl h-auto rounded-lg shadow-lg" 
             src="{{ site.baseurl }}/assets/img/bingo-demo.gif" 
             alt="Bingo Simulation Demo - Game in Action">
    </div>

    <div class="space-y-6">
        <div class="space-y-4">
            <h3 class="text-3xl font-bold leading-tight text-gray-900 sm:text-4xl dark:text-white">
                Java Bingo Simulation
            </h3>

            <p class="text-base font-normal text-gray-500 sm:text-lg dark:text-gray-400">
                This project is a simulation of the well-known game Bingo. Built using Java Swing to display a Graphical User Interface, the application allows users to print Bingo cards and simulate a Bingo game, showing drawn numbers, winning cards, and game statistics over multiple days.
            </p>
            <p class="text-base font-normal text-gray-500 sm:text-lg dark:text-gray-400">
                The application features a modern dark theme interface powered by <a href="https://github.com/JFormDesigner/FlatLaf" target="_blank" class="text-primary-600 hover:text-primary-700 dark:text-primary-500">FlatLaf</a>, professional PDF/PNG card generation using <a href="https://itextpdf.com/" target="_blank" class="text-primary-600 hover:text-primary-700 dark:text-primary-500">iText</a>, and comprehensive game result tracking and analysis.
            </p>
        </div>

        <!-- Technology Tags -->
        <div class="flex items-center gap-2.5 flex-wrap">
            <div class="p-1 rounded-lg hover:bg-gray-50 dark:hover:bg-gray-800">
                <span class="inline-flex items-center px-3 py-1 text-xs font-medium text-gray-800 bg-gray-100 rounded-full dark:bg-gray-700 dark:text-gray-300">
                    Java
                </span>
            </div>
            <div class="p-1 rounded-lg hover:bg-gray-50 dark:hover:bg-gray-800">
                <span class="inline-flex items-center px-3 py-1 text-xs font-medium text-gray-800 bg-gray-100 rounded-full dark:bg-gray-700 dark:text-gray-300">
                    Java Swing
                </span>
            </div>
            <div class="p-1 rounded-lg hover:bg-gray-50 dark:hover:bg-gray-800">
                <span class="inline-flex items-center px-3 py-1 text-xs font-medium text-gray-800 bg-gray-100 rounded-full dark:bg-gray-700 dark:text-gray-300">
                    FlatLaf
                </span>
            </div>
            <div class="p-1 rounded-lg hover:bg-gray-50 dark:hover:bg-gray-800">
                <span class="inline-flex items-center px-3 py-1 text-xs font-medium text-gray-800 bg-gray-100 rounded-full dark:bg-gray-700 dark:text-gray-300">
                    iText PDF
                </span>
            </div>
            <div class="p-1 rounded-lg hover:bg-gray-50 dark:hover:bg-gray-800">
                <span class="inline-flex items-center px-3 py-1 text-xs font-medium text-gray-800 bg-gray-100 rounded-full dark:bg-gray-700 dark:text-gray-300">
                    Maven
                </span>
            </div>
            <div class="p-1 rounded-lg hover:bg-gray-50 dark:hover:bg-gray-800">
                <span class="inline-flex items-center px-3 py-1 text-xs font-medium text-gray-800 bg-gray-100 rounded-full dark:bg-gray-700 dark:text-gray-300">
                    Game Simulation
                </span>
            </div>
        </div>

        <!-- How to Use Section -->
        <div class="mt-8">
            <h4 class="text-2xl font-bold text-gray-900 dark:text-white mb-6">How to Use</h4>

            <!-- Main Menu -->
            <div class="bg-gray-50 dark:bg-gray-900 rounded-lg p-6 mb-8">
                <h5 class="text-xl font-semibold text-gray-900 dark:text-white mb-4">Main Menu</h5>
                <p class="text-base text-gray-600 dark:text-gray-400 mb-4">
                    Enter a game code for your bingo game (this code allows you to regenerate the same bingo cards), specify the number of cards, winners, and days for the game simulation.
                </p>
                <img class="w-full h-auto rounded border border-gray-200 dark:border-gray-700 mb-4"
                     src="{{ site.baseurl }}/assets/img/main-menu.png" alt="Bingo Game Main Menu Interface">
                <p class="text-sm text-gray-600 dark:text-gray-400">
                    Choose between "Print Cards" to generate PDF/PNG files of your bingo cards, or "Play Simulation" to watch the game unfold with visual feedback.
                </p>
            </div>

            <!-- Features Grid -->
            <div class="grid grid-cols-1 md:grid-cols-2 gap-6">
                <!-- Print Cards Feature -->
                <div class="bg-gray-50 dark:bg-gray-900 rounded-lg p-6">
                    <h5 class="text-lg font-semibold text-gray-900 dark:text-white mb-2">Print Cards</h5>
                    <p class="text-sm text-gray-600 dark:text-gray-400 mb-4">Generate professional bingo cards in PDF or PNG format. Cards are automatically saved to a "BingoCards" folder and the folder opens upon completion.</p>
                    <img class="w-full h-auto rounded border border-gray-200 dark:border-gray-700"
                         src="{{ site.baseurl }}/assets/img/exportpdf.png" alt="PDF Export Example - Professional Bingo Cards">
                </div>

                <!-- Game Simulation -->
                <div class="bg-gray-50 dark:bg-gray-900 rounded-lg p-6">
                    <h5 class="text-lg font-semibold text-gray-900 dark:text-white mb-2">Bingo Simulation</h5>
                    <p class="text-sm text-gray-600 dark:text-gray-400 mb-4">Watch the game play out in real-time. Use the spinner to view different cards, draw balls, and see winners emerge with detailed game results and statistics.</p>
                    <div class="flex justify-center">
                        <img class="w-full max-w-sm h-auto rounded border border-gray-200 dark:border-gray-700"
                             src="{{ site.baseurl }}/assets/img/bingo-demo.gif" alt="Interactive Bingo Game Simulation">
                    </div>
                </div>

                <!-- Theme Customization -->
                <div class="bg-gray-50 dark:bg-gray-900 rounded-lg p-6 md:col-span-2">
                    <h5 class="text-lg font-semibold text-gray-900 dark:text-white mb-2">Theme Customization</h5>
                    <p class="text-sm text-gray-600 dark:text-gray-400 mb-4">
                        Choose from multiple modern themes powered by FlatLaf, including Nord, Dracula, Arc Dark, and many others for a personalized experience.
                    </p>
                    <div class="flex justify-center">
                        <img class="w-full max-w-2xl h-auto rounded border border-gray-200 dark:border-gray-700"
                             src="{{ site.baseurl }}/assets/img/themes.png" alt="Available UI Themes - Dark and Light Options">
                    </div>
                </div>
            </div>
        </div>

        <!-- Key Features -->
        <div class="mt-8">
            <h4 class="text-2xl font-bold text-gray-900 dark:text-white mb-6">Key Features</h4>
            <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
                <div class="bg-white dark:bg-gray-900 p-6 rounded-lg border border-gray-200 dark:border-gray-700">
                    <h5 class="font-semibold text-gray-900 dark:text-white mb-2">Seeded Random Generation</h5>
                    <p class="text-sm text-gray-600 dark:text-gray-400">Use game codes to generate reproducible bingo card sets for consistent results.</p>
                </div>
                <div class="bg-white dark:bg-gray-900 p-6 rounded-lg border border-gray-200 dark:border-gray-700">
                    <h5 class="font-semibold text-gray-900 dark:text-white mb-2">Multiple Export Formats</h5>
                    <p class="text-sm text-gray-600 dark:text-gray-400">Export cards as high-quality PDF files or individual PNG images with batch processing support.</p>
                </div>
                <div class="bg-white dark:bg-gray-900 p-6 rounded-lg border border-gray-200 dark:border-gray-700">
                    <h5 class="font-semibold text-gray-900 dark:text-white mb-2">Game Statistics</h5>
                    <p class="text-sm text-gray-600 dark:text-gray-400">Comprehensive tracking of winners, ball draws, days, and rounds with detailed result files.</p>
                </div>
                <div class="bg-white dark:bg-gray-900 p-6 rounded-lg border border-gray-200 dark:border-gray-700">
                    <h5 class="font-semibold text-gray-900 dark:text-white mb-2">Modern UI</h5>
                    <p class="text-sm text-gray-600 dark:text-gray-400">Beautiful dark theme interface with custom fonts and professional styling using FlatLaf.</p>
                </div>
                <div class="bg-white dark:bg-gray-900 p-6 rounded-lg border border-gray-200 dark:border-gray-700">
                    <h5 class="font-semibold text-gray-900 dark:text-white mb-2">Real-time Simulation</h5>
                    <p class="text-sm text-gray-600 dark:text-gray-400">Watch games play out with visual feedback, ball drawing, and winner detection across multiple days.</p>
                </div>
                <div class="bg-white dark:bg-gray-900 p-6 rounded-lg border border-gray-200 dark:border-gray-700">
                    <h5 class="font-semibold text-gray-900 dark:text-white mb-2">Cross-platform</h5>
                    <p class="text-sm text-gray-600 dark:text-gray-400">Built with Java for compatibility across Windows, macOS, and Linux systems.</p>
                </div>
            </div>
        </div>

        <!-- Installation Instructions -->
        <div class="mt-8">
            <h4 class="text-2xl font-bold text-gray-900 dark:text-white mb-6">Getting Started</h4>
            <div class="bg-gray-50 dark:bg-gray-900 rounded-lg p-6">
                <ol class="list-decimal list-inside space-y-3 text-gray-600 dark:text-gray-400">
                    <li><a href="https://www.oracle.com/java/technologies/downloads/" target="_blank" class="text-primary-600 hover:text-primary-700 dark:text-primary-500">Download</a> the latest JRE to run the .jar file</li>
                    <li><a href="https://github.com/nitheesh-cpu/Bingo-Simulation/releases/download/Download/Bingo.jar" target="_blank" class="text-primary-600 hover:text-primary-700 dark:text-primary-500">Download</a> the project .jar file from GitHub</li>
                    <li>Double-click the file to run the application</li>
                </ol>
            </div>
        </div>

        <!-- GitHub and Download Buttons -->
        <div class="mt-8 flex flex-col sm:flex-row gap-4">
            <a href="https://github.com/nitheesh-cpu/Bingo-Simulation" target="_blank" title="View Source Code"
                class="text-white inline-flex items-center justify-center bg-primary-700 hover:bg-primary-800 focus:ring-4 focus:outline-none focus:ring-primary-300 font-medium rounded-lg text-sm px-5 py-2.5 dark:bg-primary-600 dark:hover:bg-primary-700 dark:focus:ring-primary-800"
                role="button">
                <svg aria-hidden="true" class="w-5 h-5 mr-2" fill="currentColor" viewBox="0 0 24 24">
                    <path fill-rule="evenodd" d="M12 2C6.477 2 2 6.484 2 12.017c0 4.425 2.865 8.18 6.839 9.504.5.092.682-.217.682-.483 0-.237-.008-.868-.013-1.703-2.782.605-3.369-1.343-3.369-1.343-.454-1.158-1.11-1.466-1.11-1.466-.908-.62.069-.608.069-.608 1.003.07 1.531 1.032 1.531 1.032.892 1.53 2.341 1.088 2.91.832.092-.647.35-1.088.636-1.338-2.22-.253-4.555-1.113-4.555-4.951 0-1.093.39-1.988 1.029-2.688-.103-.253-.446-1.272.098-2.65 0 0 .84-.27 2.75 1.026A9.564 9.564 0 0112 6.844c.85.004 1.705.115 2.504.337 1.909-1.296 2.747-1.027 2.747-1.027.546 1.379.202 2.398.1 2.651.64.7 1.028 1.595 1.028 2.688 0 3.848-2.339 4.695-4.566 4.943.359.309.678.92.678 1.855 0 1.338-.012 2.419-.012 2.747 0 .268.18.58.688.482A10.019 10.019 0 0022 12.017C22 6.484 17.522 2 12 2z" clip-rule="evenodd"></path>
                </svg>
                View Source Code
            </a>
            <a href="https://github.com/nitheesh-cpu/Bingo-Simulation/releases/download/Download/Bingo.jar" target="_blank" title="Download Application"
                class="text-gray-900 bg-white border border-gray-300 focus:outline-none hover:bg-gray-100 focus:ring-4 focus:ring-gray-200 font-medium rounded-lg text-sm px-5 py-2.5 dark:bg-gray-800 dark:text-white dark:border-gray-600 dark:hover:bg-gray-700 dark:hover:border-gray-600 dark:focus:ring-gray-700 inline-flex items-center justify-center"
                role="button">
                <svg aria-hidden="true" class="w-5 h-5 mr-2" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 10v6m0 0l-3-3m3 3l3-3m2 8H7a2 2 0 01-2-2V5a2 2 0 012-2h5.586a1 1 0 01.707.293l5.414 5.414a1 1 0 01.293.707V19a2 2 0 01-2 2z"></path>
                </svg>
                Download JAR File
            </a>
        </div>
    </div>

</div>
