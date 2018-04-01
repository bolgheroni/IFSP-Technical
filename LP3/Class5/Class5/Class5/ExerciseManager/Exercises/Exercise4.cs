﻿using Class2_Exercises.Exercises;
using Class3.ExerciseManager;
using Class5.ExerciseManager.Exercises.Exercise4_Classes;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Class5.ExerciseManager.Exercises
{
    public class Exercise4 : IExercise
    {
        public Exercise4()
        {
            Search = new Search();
            SearchStart = new SearchStart();
            SearchEnd = new SearchEnd();
        }

        public Search Search { get; }
        public SearchStart SearchStart { get; }
        public SearchEnd SearchEnd { get; }

        public void Run()
        {
            var actions = new Dictionary<String, Action>();
            actions["Set Text"] = ReadText;
            actions["Search String"] = SearchString;
            actions["Search String Start"] = SearchStringStart;
            actions["Search String End"] = SearchStringEnd;
            //
            var menu = new ConsoleMenu(
                actions,
                "Select an option",
                "Invalid input",
                "0"
                );
            menu.Run();
        }

        private void SearchStringStart()
        {
            Console.WriteLine("\tSearching String at Start");
            var userInput = GetUserInput();
            Console.WriteLine("Result: " + (SearchStart.SearchString(userInput)));
        }

        private void SearchStringEnd()
        {
            Console.WriteLine("\tSearching String at End");
            var userInput = GetUserInput();
            Console.WriteLine("Result: " + (SearchEnd.SearchString(userInput)));
        }

        private void SearchString()
        {
            Console.WriteLine("\tSearching String");
            var userInput = GetUserInput();
            Console.WriteLine("Result: " + (Search.SearchString(userInput)));
        }

        private void ReadText()
        {
            var userInput = String.Empty;
            userInput = GetUserInput();
            SetText(userInput);
        }

        private static string GetUserInput()
        {
            Console.Write("Input a text: ");
            return Console.ReadLine();
        }

        private void SetText(string text)
        {
            SearchStart.Text = text;
            SearchEnd.Text = text;
            Search.Text = text;
        }
    }
}
